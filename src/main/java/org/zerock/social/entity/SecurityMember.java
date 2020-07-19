package org.zerock.social.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SecurityMember {

    @Id
    private String email;

    private String password;

    private String name;

    private String picture;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<MemberRole> roleSet;

    public void addMemberRole(MemberRole role){

        if(roleSet == null){
            roleSet = new HashSet<>();
        }

        roleSet.add(role);

    }
}
