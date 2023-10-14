package ${bpn??};

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

<#if hot??>
<#assign x="Int">
<#else>
<#assign x="String">
</#if>

@Repository
public interface ${obj}Repository extends JpaRepository<${obj}, ${x??}> {

}
