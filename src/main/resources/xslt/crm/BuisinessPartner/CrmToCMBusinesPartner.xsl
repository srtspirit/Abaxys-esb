<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:ns="http://abaxystechnologies.com/esb/CMBusinessPartner"
	xmlns:crm="">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<ns:businessPartner>
			<identificators>
				<identificator>
					<id>
						<xsl:value-of select="id"></xsl:value-of>
					</id>
					<systemName>
						<xsl:text>ESB.SYSTEM.CRM</xsl:text>
					</systemName>
				</identificator>
				
				<addresses>
					<address>
						<addressLine1>
							<xsl:value-of select="address"></xsl:value-of>
						</addressLine1>
						<addressLine2>
							<xsl:value-of select="address2"></xsl:value-of>
						</addressLine2>
						<city>
							<xsl:value-of select="cityName"></xsl:value-of>
						</city>
						<province>
							<xsl:value-of select="stateName"></xsl:value-of>
						</province>
						<country>
							<xsl:value-of select="countryName"></xsl:value-of>
						</country>
						<zipCode>
							<xsl:value-of select="zipcode"></xsl:value-of>
						</zipCode>
						
					</address>
				</addresses>
				
				<customer>
					<salesRepId>
						<xsl:value-of select="rep"></xsl:value-of>
					</salesRepId>
					<notes>
						<xsl:value-of select="leadnotes"></xsl:value-of>
					</notes>
				</customer>
			</identificators>
		</ns:businessPartner>
	</xsl:template>
</xsl:stylesheet>