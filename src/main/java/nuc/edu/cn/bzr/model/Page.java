package nuc.edu.cn.bzr.model;

public class Page {
    private int nowpage;
    private int Allpage;
    private int pagecount;
    private int count;
    private int nowcount;
    private int tocount;

    @Override
    public String toString() {
        return "Page{" +
                "nowpage=" + nowpage +
                ", Allpage=" + Allpage +
                ", pagecount=" + pagecount +
                ", count=" + count +
                ", nowcount=" + nowcount +
                ", tocount=" + tocount +
                '}';
    }

    public int getTocount() {
        return tocount;
    }

    public void setTocount(int tocount) {
        this.tocount = tocount;
    }

    public int getNowcount() {
        return nowcount;
    }

    public void setNowcount(int nowcount) {
        this.nowcount = nowcount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page(int nowpage,  int pagecount) {
        this.nowpage = nowpage;
        this.pagecount = pagecount;
    }
    public Page() {

    }
    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    public int getAllpage() {
        return Allpage;
    }

    public void setAllpage(int allpage) {
        Allpage = allpage;
    }
}
