<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:erp="http://www.abaxys.com/ERPBusinessPartner"
	xmlns:cm="http://abaxystechnologies.com/esb/CMBusinessPartner">
	<xsl:output indent="yes"/>
	<xsl:template match="/cm:businessPartner">
		<erp:buisinessPartner>
			<VGB_BPAR_BPART>
				<xsl:value-of select="fullName"></xsl:value-of>
			</VGB_BPAR_BPART>
			
			<customer>
				<VGB_CUST_BPNAM>
					<xsl:value-of select="fullName"/>
				</VGB_CUST_BPNAM>
				<addresses>
					<xsl:for-each select="addresses/address">
						<address>
							<VGB_ADDR_ADD01>
								<xsl:value-of select="addressLine1"/>
							</VGB_ADDR_ADD01>
							<VGB_ADDR_ADD02>
								<xsl:value-of select="addressLine2"/>
							</VGB_ADDR_ADD02>
							<VGB_ADDR_CITYN>
								<xsl:value-of select="city"/>
							</VGB_ADDR_CITYN>
							<VGB_ADDR_PRSID>
								<xsl:value-of select="province"/>
							</VGB_ADDR_PRSID>
							<VGB_ADDR_POSTC>
								<xsl:value-of select="zipCode"/>
							</VGB_ADDR_POSTC>
							
							<xsl:if test="position() = 1">
								<xsl:if test="../../customer/contacts/contactPerson[1]/personName != ''">
									<VGB_ADDR_TEL01>
										<xsl:value-of select="../../customer/contacts/contactPerson[1]/contact[@type = 'phone']"></xsl:value-of>
									</VGB_ADDR_TEL01>
									<VGB_ADDR_FAX01>
										<xsl:value-of select="../../customer/contacts/contactPerson[1]/contact[@type = 'fax']"/>
									</VGB_ADDR_FAX01>
									<VGB_ADDR_CONT1>
										<xsl:value-of select="../../customer/contacts/contactPerson[1]/personName"></xsl:value-of>
									</VGB_ADDR_CONT1>
									<VGB_ADDR_EMAIL>
										<xsl:value-of select="../../customer/contacts/contactPerson[1]/contact[@type = 'email']"/>
									</VGB_ADDR_EMAIL>
								</xsl:if>
								<xsl:if test="../../customer/contacts/contactPerson[2]/personName != ''">
									<VGB_ADDR_TEL02>
										<xsl:value-of select="../../customer/contacts/contactPerson[2]/contact[@type = 'phone']"></xsl:value-of>
									</VGB_ADDR_TEL02>
									<VGB_ADDR_FAX02>
										<xsl:value-of select="../../customer/contacts/contactPerson[2]/contact[@type = 'fax']"/>
									</VGB_ADDR_FAX02>
									<VGB_ADDR_CONT2>
										<xsl:value-of select="../../customer/contacts/contactPerson[2]/personName"></xsl:value-of>
									</VGB_ADDR_CONT2>
								</xsl:if>
							</xsl:if>
						</address>
						
					</xsl:for-each>
					
					
				</addresses>
			</customer>
		</erp:buisinessPartner>
	</xsl:template>
</xsl:stylesheet>