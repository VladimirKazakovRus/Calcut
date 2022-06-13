package Calc;
//создаем enum римских чисел
public enum Roman {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    L(50),
            C(100);

    private int fixIndex;
    Roman(int fixIndex)
    {
        this.fixIndex = fixIndex;
    }

    public int getFixIndex()
    {
        return fixIndex;
    }
    public static boolean contains(String test)
    {

        for (Roman c : Roman.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }

    public static String GetStringName(int result)
    {

        for (Roman c : Roman.values()) {
            if (c.getFixIndex() == result) {
               return c.name();
            }
        }
        return "null";
    }

    }
