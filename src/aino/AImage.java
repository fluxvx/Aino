package aino;

public class AImage<T>
{
    public T[][] C;
    private int width, height;
    public AImage(int w, int h)
    {
        width = w;
        height = h;
        C = (T[][])(new Object[w][h]);
        /*try
        {
            for (int i=0; i<width; ++i)
            {
                for (int j=0; j<height; ++j)
                {
                    C[i][j] = (T)((Class)((ParameterizedType)this.getClass().
                                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }
    public int width()
    {
        return width;
    }
    public int height()
    {
        return height;
    }
    public T get(int i, int j)
    {
        return C[i][j];
    }
    public void set(int i, int j, T t)
    {
        C[i][j] = t;
    }
}
