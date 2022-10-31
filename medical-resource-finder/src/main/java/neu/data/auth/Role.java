package neu.data.auth;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private String name;
    private String resource;
    private List<String> operations;
    private String scope;

    public Role(String name, String resource, String scope) {
        this.name = name;
        this.resource = resource;
        this.operations = new ArrayList<>();
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

    public List<String> getOperations() {
        return operations;
    }

    public String getScope() {
        return scope;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }  
}
