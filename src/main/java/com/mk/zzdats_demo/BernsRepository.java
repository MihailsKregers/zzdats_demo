package com.mk.zzdats_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BernsRepository extends JpaRepository<Berns, Long> {
    //
}
