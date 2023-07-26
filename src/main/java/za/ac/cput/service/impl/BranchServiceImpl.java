package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.impl.Branch;
import za.ac.cput.repository.IBranchRepository;
import za.ac.cput.service.IBranchService;

import java.util.List;

@Service
public class BranchServiceImpl implements IBranchService {

    private final IBranchRepository repository;

    private BranchServiceImpl(IBranchRepository repository) {
        this.repository = repository;
    }


    @Override
    public Branch save(Branch branch) {
        return this.repository.save(branch);
    }

    @Override
    public Branch update(Branch branch) {
        if(this.repository.existsById(branch.getId()))
            this.repository.save(branch);

        return null;
    }

    @Override
    public boolean delete(Integer id) {

        if(this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Branch> getAll() {
        return this.repository.findAll();
    }
}