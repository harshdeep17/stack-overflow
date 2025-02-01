package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vote extends Base {
    private User votedBy;

    public User getVotedBy() {
        return votedBy;
    }

    public void setVotedBy(User votedBy) {
        this.votedBy = votedBy;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

}
