package com.techlinemobile.securesms.crypto.storage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.techlinemobile.securesms.crypto.MasterCipher;
import com.techlinemobile.securesms.crypto.MasterSecret;
import com.techlinemobile.securesms.database.Address;
import com.techlinemobile.securesms.database.DatabaseFactory;
import com.techlinemobile.securesms.database.SessionDatabase;
import com.techlinemobile.securesms.util.Conversions;
import org.whispersystems.libsignal.InvalidMessageException;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.protocol.CiphertextMessage;
import org.whispersystems.libsignal.state.SessionRecord;
import org.whispersystems.libsignal.state.SessionState;
import org.whispersystems.libsignal.state.SessionStore;
import org.whispersystems.signalservice.api.push.SignalServiceAddress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;

import static org.whispersystems.libsignal.state.StorageProtos.SessionStructure;

public class TextSecureSessionStore implements SessionStore {

  private static final String TAG = TextSecureSessionStore.class.getSimpleName();

  private static final Object FILE_LOCK = new Object();

  @NonNull  private final Context context;

  public TextSecureSessionStore(@NonNull Context context) {
    this.context = context;
  }

  @Override
  public SessionRecord loadSession(@NonNull SignalProtocolAddress address) {
    synchronized (FILE_LOCK) {
      SessionRecord sessionRecord = DatabaseFactory.getSessionDatabase(context).load(Address.fromSerialized(address.getName()), address.getDeviceId());

      if (sessionRecord == null) {
        Log.w(TAG, "No existing session information found.");
        return new SessionRecord();
      }

      return sessionRecord;
    }
  }

  @Override
  public void storeSession(@NonNull SignalProtocolAddress address, @NonNull SessionRecord record) {
    synchronized (FILE_LOCK) {
      DatabaseFactory.getSessionDatabase(context).store(Address.fromSerialized(address.getName()), address.getDeviceId(), record);
    }
  }

  @Override
  public boolean containsSession(SignalProtocolAddress address) {
    synchronized (FILE_LOCK) {
      SessionRecord sessionRecord = DatabaseFactory.getSessionDatabase(context).load(Address.fromSerialized(address.getName()), address.getDeviceId());

      return sessionRecord != null &&
             sessionRecord.getSessionState().hasSenderChain() &&
             sessionRecord.getSessionState().getSessionVersion() == CiphertextMessage.CURRENT_VERSION;
    }
  }

  @Override
  public void deleteSession(SignalProtocolAddress address) {
    synchronized (FILE_LOCK) {
      DatabaseFactory.getSessionDatabase(context).delete(Address.fromSerialized(address.getName()), address.getDeviceId());
    }
  }

  @Override
  public void deleteAllSessions(String name) {
    synchronized (FILE_LOCK) {
      DatabaseFactory.getSessionDatabase(context).deleteAllFor(Address.fromSerialized(name));
    }
  }

  @Override
  public List<Integer> getSubDeviceSessions(String name) {
    synchronized (FILE_LOCK) {
      return DatabaseFactory.getSessionDatabase(context).getSubDevices(Address.fromSerialized(name));
    }
  }

  public void archiveSiblingSessions(@NonNull SignalProtocolAddress address) {
    synchronized (FILE_LOCK) {
      List<SessionDatabase.SessionRow> sessions = DatabaseFactory.getSessionDatabase(context).getAllFor(Address.fromSerialized(address.getName()));

      for (SessionDatabase.SessionRow row : sessions) {
        if (row.getDeviceId() != address.getDeviceId()) {
          row.getRecord().archiveCurrentState();
          storeSession(new SignalProtocolAddress(row.getAddress().serialize(), row.getDeviceId()), row.getRecord());
        }
      }
    }
  }

  public void archiveAllSessions() {
    synchronized (FILE_LOCK) {
      List<SessionDatabase.SessionRow> sessions = DatabaseFactory.getSessionDatabase(context).getAll();

      for (SessionDatabase.SessionRow row : sessions) {
        row.getRecord().archiveCurrentState();
        storeSession(new SignalProtocolAddress(row.getAddress().serialize(), row.getDeviceId()), row.getRecord());
      }
    }
  }
}