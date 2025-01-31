package com.example.stackoverflow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vote extends Base {
    private int value;
    private User votedBy;
}
