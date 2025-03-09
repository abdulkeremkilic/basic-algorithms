package Model;

public class CNode {
    CNode branch1;
    CNode branch2;
    String val;

    public CNode(String val) {
        this.val = val;
    }

    public CNode(CNode branch1, CNode branch2, String val) {
        this.branch1 = branch1;
        this.branch2 = branch2;
        this.val = val;
    }

    public CNode getBranch1() {
        return branch1;
    }

    public void setBranch1(CNode branch1) {
        this.branch1 = branch1;
    }

    public CNode getBranch2() {
        return branch2;
    }

    public void setBranch2(CNode branch2) {
        this.branch2 = branch2;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
