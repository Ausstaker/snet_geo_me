package au.com.ausstaker.snet.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author edge2ipi (https://github.com/Ausstaker)
 */
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Map<String, Status> TYPES = new LinkedHashMap<String, Status>();

    public static final Status OK = new Status("ok", "Ok");
    public static final Status NO_OBSERVATIONS = new Status("no_obs_err", "No Observations");
    public static final Status NOT_ENOUGH_OBSERVATIONS = new Status("num_obs_err", "Not Enough Observations");
    public static final Status NO_TARGET_DESCRIPTION = new Status("no_tgt_err", "No Target Description");
    public static final Status MISSION_CONFIG_ERROR = new Status("msn_cfg_err", "Mission Configuration Error");
    public static final Status OBSERVATION_ILL_FORMED = new Status("obs_ill_err", "An observation was ill Formed. Check all mandatory fields are defined");
    public static final Status UNKNOWN = new Status("ukn_err", "Unknown");

    public Status(final String type, final String friendlyType) {
        setType(type);
        this.friendlyType = friendlyType;
    }

    public static Status getInstance(final String type) {
        return TYPES.get(type);
    }

    private String type;
    private String friendlyType;


    public Status() {
        //do nothing
    }
    
    public String getType() {
        return type;
    }

    public String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type, this);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!getClass().isAssignableFrom(obj.getClass()))
            return false;
        Status other = (Status) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
}