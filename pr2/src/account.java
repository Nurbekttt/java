public class account {
    private String name;
    private long time;
    private String level;
    public account(String name,String level){
        this.name=name;
        this.level=level;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
