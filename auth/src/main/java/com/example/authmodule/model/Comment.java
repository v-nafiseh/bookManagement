package com.example.authmodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Comment {
    private String UName;
    private String content;
    private long Bid;
}
