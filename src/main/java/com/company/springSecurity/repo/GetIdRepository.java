package com.company.springSecurity.repo;

import com.company.springSecurity.model.GetId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetIdRepository extends JpaRepository<GetId,Long>{
}
