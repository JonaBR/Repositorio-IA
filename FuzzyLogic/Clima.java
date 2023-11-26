
import jFuzzyLogic.FIS;
import jFuzzyLogic.rule.Rule;
import jFuzzyLogic.rule.RuleSet;
import jFuzzyLogic.variable.Variable;

public class Clima {

    public static void main(String[] args) {
        // Definir variables lingüísticas
        Variable temperatura = new Variable("temperatura", 0.0, 1.0);
        Variable humedad = new Variable("humedad", 0.0, 1.0);

        // Definir conjuntos difusos
        temperatura.addTerm(new Term("alta", new TriangleFunction(0.9, 1.0, 1.0)));
        temperatura.addTerm(new Term("media", new TriangleFunction(0.4, 0.7, 0.9)));
        temperatura.addTerm(new Term("baja", new TriangleFunction(0.0, 0.3, 0.4)));

        humedad.addTerm(new Term("alta", new TriangleFunction(0.9, 1.0, 1.0)));
        humedad.addTerm(new Term("media", new TriangleFunction(0.4, 0.7, 0.9)));
        humedad.addTerm(new Term("baja", new TriangleFunction(0.0, 0.3, 0.4)));

        // Definir reglas difusas
        RuleSet ruleSet = new RuleSet();
        ruleSet.addRule(new Rule("si temperatura es alta y humedad es alta, entonces clima es cálido"));
        ruleSet.addRule(new Rule("si temperatura es media y humedad es alta, entonces clima es templado"));
        ruleSet.addRule(new Rule("si temperatura es baja y humedad es alta, entonces clima es fresco"));
        ruleSet.addRule(new Rule("si temperatura es alta y humedad es media, entonces clima es seco"));
        ruleSet.addRule(new Rule("si temperatura es baja y humedad es media, entonces clima es húmedo"));

        // Crear un sistema experto
        FIS fis = new FIS();
        fis.addVariable(temperatura);
        fis.addVariable(humedad);
        fis.addRuleSet(ruleSet);

        // Inicializar las variables
        temperatura.setValue(0.7);
        humedad.setValue(0.9);

        // Inferir el clima
        fis.evaluate();

        // Obtener el resultado
        String clima = fis.getVariable("clima").defuzzify();

        System.out.println("El clima es " + clima);
    }
}
