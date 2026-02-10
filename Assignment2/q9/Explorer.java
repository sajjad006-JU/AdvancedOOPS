// A  Planet  Explorer  routinely  travels  across  the  planets  in  the  Solar  System  to  discover  life  form, 
// minerals  available,  etc.  However,  the  method  of  exploring  is  different  on  each  planet,  due  to  the 
// difference in atmosphere and surface composition. Every explorer should have an explore method 
// that is defined based on the type of the explorer and the planet where (s)he is exploring. Consider 
// three planets-Mars, Venus, and Saturn. 
// Implement it using interfaces, abstract class, inheritance. 
import java.util.ArrayList;
import java.util.List;

interface PlanetExplorer {
    void visit(Mars mars);
    void visit(Venus venus);
    void visit(Saturn saturn);
}

interface Planet {
    void explore(PlanetExplorer explorer);
}

class Mars implements Planet {
    public void explore(PlanetExplorer explorer) {
        explorer.visit(this);
    }
}

class Saturn implements Planet {
    public void explore(PlanetExplorer explorer) {
        explorer.visit(this);
    }
}

class Venus implements Planet {
    public void explore(PlanetExplorer explorer) {
        explorer.visit(this);
    }
}

class MineralExplorer implements PlanetExplorer {
    public void visit(Venus venus) {
        System.out.println("minerls of venus.....");
    }

    public void visit(Mars mars) {
        System.out.println("minerls of mars.....");
    }

    public void visit(Saturn saturn) {
        System.out.println("minerls of saturn.....");
    }

}

class LifeformExplorer implements PlanetExplorer {
    public void visit(Venus venus) {
        System.out.println("life forms of venus.....");
    }

    public void visit(Mars mars) {
        System.out.println("life forms of mars.....");
    }

    public void visit(Saturn saturn) {
        System.out.println("life forms of saturn.....");

    }
}

public class Explorer {
    public static void main(String[] args) {        
        List<Planet> planets = new ArrayList<>();
        planets.add(new Mars());
        planets.add(new Venus());
        planets.add(new Saturn());
        
        MineralExplorer lfe=new MineralExplorer();
        for (Planet planet : planets) {
            planet.explore(lfe);
        }
    }
}
