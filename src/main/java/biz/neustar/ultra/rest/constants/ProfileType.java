package biz.neustar.ultra.rest.constants;

public enum ProfileType {
    NONE(""),
    RD_POOL("http://schemas.ultradns.com/RDPool.jsonschema"),
    DIR_POOL("http://schemas.ultradns.com/DirPool.jsonschema");

    private final String context;

    ProfileType(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }
}
