package dto;

public enum GoldSource
{
    COMPLETE_TASK("complete task"),
    USER_DONATE("user donate"),
    UNKNOWN ("unknown");
    private String source;
    GoldSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
}
