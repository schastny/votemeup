package up.voteme.service;

import up.voteme.domain.Attachment;
import up.voteme.domain.Comment;
import up.voteme.domain.Proposal;

import java.util.List;

public interface AttachmentDAO
{
    public void addAttachment(Attachment attachment);

    public void deleteAttachment(Attachment attachment);

    public Attachment getAttachment(int id);

    public List<Attachment> getAllAttachmentsByProposal(Proposal proposal);

    public List<Attachment> getAllAttachmentsByComment(Comment comment);
}
