<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:crm="http://crm">

	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>	
	
	<xsl:template match="crm:createdDate">
		<crm:createdDate>
			<xsl:value-of select="replace(text(), ' ', 'T')"/>
		</crm:createdDate>
	</xsl:template>
</xsl:stylesheet>