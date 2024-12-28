package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.InstituteService;
import com.development.instituteDemo.layers.models.Institute;
import com.development.instituteDemo.layers.repositories.repositories.InstituteRepository;
import org.springframework.stereotype.Service;

@Service
public class InstituteServiceImpl implements InstituteService {
    private InstituteRepository instituteRepository;

    public InstituteServiceImpl(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    @Override
    public Institute saveInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }
}
