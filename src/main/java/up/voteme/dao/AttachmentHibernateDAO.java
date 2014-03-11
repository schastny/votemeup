package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Attachment;
import up.voteme.domain.Proposal;
import up.voteme.exception.dao.AttachmentDAOException;
import up.voteme.service.AttachmentDAO;

import java.util.List;

import static up.voteme.util.HibernateUtil.*;

public class AttachmentHibernateDAO implements AttachmentDAO {

//   ivan !lox  sasha lox
    @Override
    public void addAttachment(Attachment attachment) throws AttachmentDAOException {
        try {
            begin();
            getSession().save(attachment);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new AttachmentDAOException("Could't add attachment!" + attachment, e);
        }
    }

    @Override
    public void deleteAttachment(Attachment attachment) throws AttachmentDAOException {
        try {
            begin();
            getSession().delete(attachment);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new AttachmentDAOException("Could't delete attachment!" + attachment, e);
        }
    }

    @Override
    public Attachment getAttachment(int id) throws AttachmentDAOException {
        Attachment attachment;
        try {
            begin();
            attachment = (Attachment) getSession().get(Attachment.class, id);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new AttachmentDAOException("Could't get attachment by ID!" + id, e);
        }
        return attachment;
    }

    @Override
    public List<Attachment> getAllAttachmentsByProposal(Proposal proposal) throws AttachmentDAOException {
        List<Attachment> attachments;
        try {
            begin();
            int proposalId = proposal.getId();
            attachments = (List<Attachment>) getSession().createQuery("from Attachment where proposal_id =:proposalId")
                    .setInteger("proposalId", proposalId)
                    .list();
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new AttachmentDAOException("Could't get all attachments by proposal!" + proposal, e);
        }
        return attachments;
    }

}
