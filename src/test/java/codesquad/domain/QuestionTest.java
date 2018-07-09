package codesquad.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class QuestionTest {
    @Test
    public void 질문수정() {
        Question question = new Question("권현아", "제목", "내용");
        Question modifiedQuestion = new Question("권현아", "제목수정", "내용수정");

        question.update(modifiedQuestion);
        assertEquals(question.getWriter(), modifiedQuestion.getWriter());
        assertEquals(question.getTitle(), modifiedQuestion.getTitle());
        assertEquals(question.getContents(), modifiedQuestion.getContents());
    }
}