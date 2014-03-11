package up.voteme.service;

import up.voteme.domain.Attachment;
import up.voteme.domain.Proposal;
import up.voteme.exception.dao.AttachmentDAOException;

import java.util.List;

public interface AttachmentDAO {
    public void addAttachment(Attachment attachment) throws AttachmentDAOException;

    public void deleteAttachment(Attachment attachment) throws AttachmentDAOException;

    public Attachment getAttachment(int id) throws AttachmentDAOException;

    public List<Attachment> getAllAttachmentsByProposal(Proposal proposal) throws AttachmentDAOException;
}
