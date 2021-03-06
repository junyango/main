package seedu.address.logic.parser.person;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.person.FbCommand.MESSAGE_USAGE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.person.FbCommand;

//@@author junyango
public class FbCommandParserTest {
    private final FbCommandParser parser = new FbCommandParser();

    @Test
    public void parse_validIndex_checkCorrectness() {
        Command expected = new FbCommand(Index.fromOneBased(1));
        assertParseSuccess(parser, " 1 ", expected);
    }

    @Test
    public void parse_invalidIndex_expectException() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT , MESSAGE_USAGE);
        assertParseFailure(parser, " -1 ", expectedMessage);
    }
}
