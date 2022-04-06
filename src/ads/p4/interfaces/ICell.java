package ads.p4.interfaces;

public interface ICell {
    public int getRow();

    public int getColumn();

    public IToken getToken();

    public void setToken(IToken f);

    public boolean isNeighbor(ICell c);
}
