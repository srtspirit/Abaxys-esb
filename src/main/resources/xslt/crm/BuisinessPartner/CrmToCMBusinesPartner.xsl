<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns="http://abaxystechnologies.com/esb/CMBusinessPartner"
	xmlns:crm="http://crm">
	<xsl:output indent="yes"/>
	<xsl:template match="/crm:businessPartner">
		<!-- TODO: Auto-generated template -->
		<ns:businessPartner>
			<identificators>
				<identificator>
					<id>
						<xsl:value-of select="crm:id"></xsl:value-of>
					</id>
					<systemName>
						<xsl:text>ESB.SYSTEM.CRM</xsl:text>
					</systemName>
				</identificator>
			</identificators>
			
			<fullName>
				<xsl:value-of select="crm:lead"/>
			</fullName>
			<addresses>
				<address>
					<addressLine1>
						<xsl:value-of select="crm:address"></xsl:value-of>
					</addressLine1>
					<addressLine2>
						<xsl:value-of select="crm:address2"></xsl:value-of>
					</addressLine2>
					<city>
						<xsl:value-of select="crm:cityName"></xsl:value-of>
					</city>
					<province>
						<xsl:value-of select="crm:stateName"></xsl:value-of>
					</province>
					<country>
						<xsl:value-of select="crm:countryName"></xsl:value-of>
					</country>
					<zipCode>
						<xsl:value-of select="crm:zipcode"></xsl:value-of>
					</zipCode>
					
				</address>
			</addresses>
			
			<customer>
				<salesRepId>
					<xsl:value-of select="crm:rep"></xsl:value-of>
				</salesRepId>
				<notes>
					<xsl:value-of select="crm:leadnotes"></xsl:value-of>
				</notes>
				
				<contacts>
					<xsl:if test="crm:primaryName != '' or crm:primarylastName != ''">
						<contactPerson>
							<xsl:attribute name="type">
							
									<xsl:text>primary</xsl:text>
								
							</xsl:attribute>
							
							<personName>
									<xsl:value-of select="concat(crm:primaryName, crm:primaryLastName)"/>
							</personName>
								
							<xsl:if test="crm:primaryPhone != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>phone</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="concat(crm:primaryPhone, crm:primaryphoneExtension)"/>
								</contact>
							</xsl:if>
							
							<xsl:if test="crm:primaryMobile != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>cellPhone</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="crm:primaryMobile"/>
								</contact>
							</xsl:if>
							
							<xsl:if test="crm:primaryEmail != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>email</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="crm:primaryEmail"/>
								</contact>
							</xsl:if>
						</contactPerson>
					</xsl:if>
					
					<xsl:if test="crm:secondaryName != '' or crm:secondaryLastName != ''">
						<contactPerson>
							<xsl:attribute name="type">
								
									<xsl:text>secondary</xsl:text>
							
							</xsl:attribute>
							
							<personName>
									<xsl:value-of select="concat(crm:secondaryName, crm:secondaryLastName)"/>
							</personName>
								
							<xsl:if test="crm:secondaryPhone != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>phone</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="concat(crm:secondaryPhone, crm:secondaryphoneExtension)"/>
								</contact>
							</xsl:if>
							
							<xsl:if test="crm:secondaryMobile != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>cellPhone</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="crm:secondaryMobile"/>
								</contact>
							</xsl:if>
							
							<xsl:if test="crm:secondaryEmail != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>email</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="crm:secondaryEmail"/>
								</contact>
							</xsl:if>
						</contactPerson>
					</xsl:if>
					
					<xsl:if test="crm:thirdConName != '' or crm:thirdConLastName != ''">
						<contactPerson>
							<xsl:attribute name="type">
								
									<xsl:text>thirdCon</xsl:text>
								
							</xsl:attribute>
							
							<personName>
									<xsl:value-of select="concat(crm:thirdConName, crm:thirdConLastName)"/>
							</personName>
								
							<xsl:if test="crm:thirdConPhone != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>phone</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="concat(crm:thirdConPhone, crm:thirdConphoneExtension)"/>
								</contact>
							</xsl:if>
							
							<xsl:if test="crm:thirdConMobile != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>cellPhone</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="crm:thirdConMobile"/>
								</contact>
							</xsl:if>
							
							<xsl:if test="crm:thirdConEmail != ''">
								<contact>
									<xsl:attribute name="type">
										<xsl:text>email</xsl:text>
									</xsl:attribute>
									<xsl:value-of select="crm:thirdConEmail"/>
								</contact>
							</xsl:if>
						</contactPerson>
					</xsl:if>
				</contacts>
			</customer>
		</ns:businessPartner>
	</xsl:template>
</xsl:stylesheet>