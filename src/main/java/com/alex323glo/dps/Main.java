package com.alex323glo.dps;

import com.alex323glo.dps.interpreter.Interpreter;
import com.alex323glo.dps.interpreter.InterpreterImpl;
import com.alex323glo.dps.interpreter.model.state.State;
import com.alex323glo.dps.interpreter.model.state.StateData;
import com.alex323glo.dps.interpreter.model.state.map.MapState;
import com.alex323glo.dps.parser.CommandParserImpl;
import com.alex323glo.dps.parser.model.command.executor.Executor;
import com.alex323glo.dps.parser.model.command.executor.ExecutorFactory;
import com.alex323glo.dps.parser.model.command.executor.ExecutorFactoryHolder;
import com.dima.dps.parser.parser_commands.SyntaxCommand;
import com.dima.dps.parser.parser_commands.context.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex323glo on 30.11.17.
 */
public class Main {

    private static List<SyntaxCommand> syntaxCommandList = new ArrayList<>();
    private static ExecutorFactoryHolder executorFactoryHolder = ExecutorFactoryHolder.getInstance();

    public static void main(String[] args) throws Exception {
        addContextToSyntaxCommandList();

        Interpreter interpreter = new InterpreterImpl(new CommandParserImpl(syntaxCommandList));
        State initialState = new MapState();
        String command = "context(value:'Hello')";

        System.out.println("State:\n" + initialState);

        State newState = interpreter.interpret(initialState, command);

        System.out.println("\nNew state:\n" + newState);
    }

    // Adding "context" command to SyntaxCommand List and ExecutorFactoryHolder:
    private static void addContextToSyntaxCommandList() {
        syntaxCommandList.add(new Context());
        executorFactoryHolder.addFactory(Context.class.getName(), new ExecutorFactory() {
            @Override
            public Executor create() {
                return (command, state, config) -> {
                    if (command == null || state == null) {
                        throw new NullPointerException("command or state is null");
                    }

                    State newState = state.deepCopy();

                    Object tempValue = command.getSettings().get("value");

                    newState.put(
                            "head.type",
                            new StateData(Class.class, tempValue.getClass())
                    );

                    newState.put(
                            "head.data",
                            new StateData(tempValue.getClass(), tempValue)
                    );

                    return newState;
                };
            }
        });
    }

}
