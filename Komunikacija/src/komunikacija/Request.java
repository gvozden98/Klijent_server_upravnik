/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

/**
 *
 * @author Ognjen
 */
public class Request {
    private Operacija operation;
    private Object argument;

    public Request() {
    }

    public Request(Operacija operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public Operacija getOperation() {
        return operation;
    }

    public void setOperation(Operacija operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Request{" + "operation=" + operation + ", argument=" + argument + '}';
    }
    
    
}
