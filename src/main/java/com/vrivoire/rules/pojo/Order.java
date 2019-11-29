package com.vrivoire.rules.pojo;

import java.util.Objects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Order {

    private transient static final Logger LOGGER = LogManager.getLogger(Order.class);
    private String title;
    private boolean membership = false;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addLine(String line) {
        LOGGER.info("Order: added a free “" + line + "” video to the packing slip");
    }

    public boolean hasMembership() {
        return membership;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + (this.membership ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.membership != other.membership) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order [");
        builder.append("getTitle=").append(getTitle());
        builder.append(", hasMembership=").append(hasMembership());
        builder.append("]");
        return builder.toString();
    }
}
