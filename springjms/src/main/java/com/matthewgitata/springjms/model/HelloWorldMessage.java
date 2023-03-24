package com.matthewgitata.springjms.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * created by @matthewgitata on 24/03/2023.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {
    static final long serialVersionUID = 42L;
    private UUID id;
    private String message;
}