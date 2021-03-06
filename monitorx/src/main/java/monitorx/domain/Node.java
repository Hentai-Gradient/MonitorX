package monitorx.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import monitorx.plugins.Status;
import monitorx.plugins.sync.ISyncConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Node that need to be monitored
 *
 * @author qianlifeng
 */
public class Node {
    String group;
    String code;
    String title;
    String sync;
    ISyncConfig syncConfig;
    Status status;
    List<Forewarning> forewarnings = new ArrayList<Forewarning>();

    @JSONField(serialize = false)
    @JsonIgnore
    List<Status> statusHistory = new ArrayList<Status>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public ISyncConfig getSyncConfig() {
        return syncConfig;
    }

    public void setSyncConfig(ISyncConfig syncConfig) {
        this.syncConfig = syncConfig;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Status> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(List<Status> statusHistory) {
        this.statusHistory = statusHistory;
    }

    public List<Forewarning> getForewarnings() {
        return forewarnings;
    }

    public void setForewarnings(List<Forewarning> forewarnings) {
        this.forewarnings = forewarnings;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Node)) {
            return false;
        }
        Node otherNode = (Node) other;
        return this.code.equals(otherNode.getCode());
    }
}