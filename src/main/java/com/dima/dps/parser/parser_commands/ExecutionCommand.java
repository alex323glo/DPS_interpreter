package com.dima.dps.parser.parser_commands;

import org.json.JSONObject;

public class ExecutionCommand {
    private SyntaxCommand syntaxCommand;
    private JSONObject params;

    public ExecutionCommand(SyntaxCommand syntaxCommand, String params) {
        this.syntaxCommand = syntaxCommand;
        this.params = new JSONObject(params);
    }

    public SyntaxCommand getSyntaxCommand() {
        return syntaxCommand;
    }

    public void setSyntaxCommand(SyntaxCommand syntaxCommand) {
        this.syntaxCommand = syntaxCommand;
    }

    public JSONObject getParams() {
        return params;
    }

    public void setParams(JSONObject params) {
        this.params = params;
    }
}
