package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.SemesterService;
import com.development.instituteDemo.layers.models.Semester;
import com.development.instituteDemo.layers.repositories.repositories.SemesterRepository;
import org.springframework.stereotype.Service;

@Service
public class SemesterServiceImpl implements SemesterService {
    private SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }
}
