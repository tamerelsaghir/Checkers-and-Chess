package com.example.guanghuili.checkesandchess.Checkers;

import android.util.Log;

import java.io.Serializable;

public class Player extends RoomManager implements Serializable {
    private String username;
    private String email;
    private String id;
    private int win;
    private int loss;
    private String winningRate;

    public Player(){

    }
    public Player(String username, String email){
        this.username = username;
        this.email = email;
        this.win = 0;
        this.loss = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWin() {
        return win;
    }

    public void updateWin() {
        this.win++;
        updateWinningRate();

    }

    public int getLoss() {
        return loss;
    }

    public void updateLoss() {
        this.loss++;
        updateWinningRate();
    }

    public void updateWinningRate(){
        double rate;
        if((win + loss) != 0){
            rate = (Math.round(((double)win/(double)(win+loss))*100)/(double)100);
            rate = rate * 100;
            Log.d("Winning Rate",String.valueOf(rate));
            this.winningRate = String.valueOf(rate) + "%";
        }
        else{
            this.winningRate = "0%";
        }
    }

    public String getWinningRate() {
        return winningRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
