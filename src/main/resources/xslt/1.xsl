<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:fn="http://www.w3.org/2005/xpath-functions">

	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>	
	
	<xsl:template match="createdDate">
		<createdDate>
			
<!-- 			<xsl:text>2001-01-21T10:10:10</xsl:text>		 -->
			<xsl:variable name="text" select="text()"></xsl:variable>
			<xsl:value-of select="fn:replace(text(), ' ', 'T')"/>
		</createdDate>
	</xsl:template>
</xsl:stylesheet>