package com.reach_u.kov48.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Support {

    private String type;

    private int amount;

    private String status;

    private boolean selected;

}
