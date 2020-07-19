package org.zerock.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.social.entity.SecurityMember;

public interface SecurityMemberRepository extends JpaRepository<SecurityMember, String> {

}
