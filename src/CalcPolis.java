import java.util.*;

public class CalcPolis {

    List<Token> polis;
    //Queue<Token> stack = new LinkedList<>();
    List<Var_table> var_table = new LinkedList<>();
    HashSet h = new HashSet();
    Stack<Token> stack = new Stack<>();

    CalcPolis(List<Token> _polis){
        polis = _polis;
    }

    //вычисление полиса
    void calc_polis(){

        Token var = new Token();
        boolean jmp = false;

        int polis_size = polis.size();
        for (int i = 0; i < polis_size; i++){

            Token item = polis.get(i);

            if(item.type == "VAR" || item.type == "NUM" || item.type == "JUMP"){
                stack.add(item);
            }

            if(item.type == "ASSIGN_OP"){
                var = stack.pop();
            }

            if(item.type == "OP"){
                ops(var.token, stack.pop().token, stack.pop().token, item.token);
            }

            if (item.type == "LOG_OP"){
                jmp = log_ops(item.token, stack.pop().token, stack.pop().token);
            }


            if (item.type == "MYST"){
                if(item.token.equals("_set")){
                    i++;
                    Token item_2 = polis.get(i);
                    HashSet hs = new HashSet();
                    var_table.add(new Var_table(item_2.token, hs, "HS"));
                }

                if (item.token.equals("_put")){
                    i++;
                    String var_1 = polis.get(i).token;
                    i++;
                    Double _first;

                    try {
                        _first = Double.parseDouble(polis.get(i).token);
                    }catch (Exception var2){
                        _first = (Double)find_var(polis.get(i).token);
                    }

                    for (Var_table item_1 : var_table){
                        if(item_1.name.equals(var_1)){
                            HashSet hs = (HashSet)item_1.value;
                            hs.mset(_first);
                        }
                    }
                }


                i++;

            }



            if (item.type == "IF"){

                System.out.println("\n" + !jmp + "---------------------------");
                for (Var_table itemm : var_table){
                    System.out.println(itemm.name + " " + itemm.value);
                }



                int jump = Integer.parseInt(stack.pop().token);

                if(jump > i){
                    if(!jmp){
                        i = jump;
                        System.out.println("\njump to i\n");
                    }
                }
                else {
                    if(jmp){
                        i = jump;
                        System.out.println("\njump to i\n");
                    }
                }

            }
        }


        System.out.println("\n");
        for (Var_table itemm : var_table){
            System.out.println(itemm.name + " " + itemm.value);
        }


    }

    //вычисление арифметического выражения
    void ops(String var, String first , String second, String op){


        Double _first, _second;


        try {
            _first = Double.parseDouble(first);
        }catch (Exception var2){
            _first = (Double)find_var(first);
        }

        try {
            _second = Double.parseDouble(second);
        }catch (Exception var2){
            _second = (Double)find_var(second);
        }

        Double result = 0.0;

        switch (op){
            case "+":
                result = _first + _second;
                break;
            case "-":
                result = _first - _second;
                break;
            case "*":
                result = _first * _second;
                break;
            case "/":
                result = _first / _second;
                break;

        }
        stack.add(new Token("NUM", String.valueOf(result)));
        if(contain_var(var))
            change_var(var, result);
        else
            var_table.add(new Var_table( var, result, "NUM"));
    }

    //вычисление логического выражения
    boolean log_ops(String op, String second, String first) {
        Double _first, _second;

        try {
            _first = Double.parseDouble(first);
        } catch (Exception var2) {
            _first = (Double)find_var(first);
        }

        try {
            _second = Double.parseDouble(second);
        } catch (Exception var2) {
            _second = (Double)find_var(second);
        }

        boolean result = false;

        switch (op) {
            case "==":
                result = _second == _first;
            break;
            case ">":
                result = _first > _second;
                break;
            case "<":
                result = _first < _second;
                break;
            case ">=":
                result = _first >= _second;
                break;
            case "<=":
                result = _first <= _second;
                break;
            case "!=":
                result = _first != _second;
                break;
        }
        return result;

    }

    //возвращает значение переменной var из таблицы переменных
    Object find_var(String var){

        for (Var_table item : var_table){
            if(item.name.equals(var))
                return item.value;
        }
        return 0;
    }

    // проверяет есть ли переменная var в таблице переменных
    boolean contain_var(String var){
        for (Var_table item : var_table){
            if(item.name.equals(var) )
                return true;
        }

        return false;
    }

    //меняет значение переменной var
    void change_var(String var, Double value){
        for (Var_table item : var_table){
            if(item.name.equals(var))
                item.value = value;
        }
    }

}




/*
    String type = item.token;
                i++;
                        Double value;

                        try {
                        value = Double.parseDouble(polis.get(i).token);
                        }catch (Exception var2) {
                        value = find_var(polis.get(i).token);
                        }

                        if (type.equals("_set"))
                        h.mset(value);

                        if (type.equals("_get"))
                        System.out.println("get " + h.mget(value));
                        */