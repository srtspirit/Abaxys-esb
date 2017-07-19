<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>	
	
	<xsl:template match="createdDate">
		<createdDate>
			<xsl:value-of select="replace(text(), ' ', 'T')"/>
		</createdDate>
	</xsl:template>
</xsl:stylesheet>