package com.techlinemobile.securesms.mms;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.mms.pdu_alt.SendConf;

import com.techlinemobile.securesms.transport.UndeliverableMessageException;


public interface OutgoingMmsConnection {
  @Nullable
  SendConf send(@NonNull byte[] pduBytes, int subscriptionId) throws UndeliverableMessageException;
}
