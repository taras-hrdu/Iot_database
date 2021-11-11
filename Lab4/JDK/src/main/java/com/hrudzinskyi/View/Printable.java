package com.hrudzinskyi.View;

import java.sql.SQLException;

@FunctionalInterface
public interface Printable {
    void print() throws SQLException;
}
