package com.rexru.cheeseburgernocheese;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.plus.Plus;
import com.google.example.games.basegameutils.BaseGameUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
    implements GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    RoomUpdateListener, RealTimeMessageReceivedListener,
    RoomStatusUpdateListener
{
    GoogleApiClient googleApiClient;
    boolean isResolvingConnectionFailure, wasSignInClicked, isAutoStartSignInAllowed = true;
    static int RESOLVING_CONNECTION = 999;
    static int WAITING_ROOM = 899;
    String roomId;
    String myId;
    ArrayList<Participant> participants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        startQuickGame();
    }

    public void startQuickGame()
    {
        Bundle am = RoomConfig.createAutoMatchCriteria(1,1,0);
        RoomConfig.Builder roomConfigBuilder = RoomConfig.builder(this);
        roomConfigBuilder.setAutoMatchCriteria(am);
        RoomConfig roomConfig = roomConfigBuilder.build();
        Games.RealTimeMultiplayer.create(googleApiClient,roomConfig);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (isResolvingConnectionFailure)
            return;
        if (wasSignInClicked || isAutoStartSignInAllowed)
        {
            isAutoStartSignInAllowed = false;
            wasSignInClicked = true;
            isResolvingConnectionFailure = true;
        }
        if (!BaseGameUtils.resolveConnectionFailure(this, googleApiClient,
                connectionResult, RESOLVING_CONNECTION, "NOT RESOLVING CONNECTION"))
            isResolvingConnectionFailure = false;
    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();
    }

    @Override
    public void onRoomCreated(int i, Room room) {
        Intent intent = Games.RealTimeMultiplayer.getWaitingRoomIntent(
                googleApiClient,room,2);
        startActivityForResult(intent,WAITING_ROOM);
    }

    @Override
    public void onJoinedRoom(int i, Room room) {

    }

    @Override
    public void onLeftRoom(int i, String s) {

    }

    @Override
    public void onRoomConnected(int i, Room room) {

    }

    @Override
    public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
        byte[] realTimeData = realTimeMessage.getMessageData();
        String sender = realTimeMessage.getSenderParticipantId();

        for(Participant p : participants) {
            if (p.getStatus() != Participant.STATUS_JOINED)
                continue;
            Games.RealTimeMultiplayer.sendReliableMessage
                    (googleApiClient, null, realTimeData, roomId, p.getParticipantId());
            Games.RealTimeMultiplayer.sendUnreliableMessage
                    (googleApiClient, realTimeData, roomId, p.getParticipantId());
        }
    }

    @Override
    public void onConnectedToRoom(Room room) {
        roomId = room.getRoomId();
        participants = room.getParticipants();
        myId = room.getParticipantId(Games.Players.getCurrentPlayerId
                (googleApiClient));

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.id.myimage, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;
    }

    @Override
    public void onRoomConnecting(Room room) {

    }

    @Override
    public void onRoomAutoMatching(Room room) {

    }

    @Override
    public void onPeerInvitedToRoom(Room room, List<String> strings) {

    }

    @Override
    public void onPeerDeclined(Room room, List<String> strings) {

    }

    @Override
    public void onPeerJoined(Room room, List<String> strings) {

    }

    @Override
    public void onPeerLeft(Room room, List<String> strings) {

    }

    @Override
    public void onDisconnectedFromRoom(Room room) {

    }

    @Override
    public void onPeersConnected(Room room, List<String> strings) {

    }

    @Override
    public void onPeersDisconnected(Room room, List<String> strings) {

    }

    @Override
    public void onP2PConnected(String s) {

    }

    @Override
    public void onP2PDisconnected(String s) {

    }
}