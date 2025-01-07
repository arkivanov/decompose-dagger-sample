package com.example.myapplication.myprocessor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import java.io.PrintWriter

class ProcessorImpl(
    private val generator: CodeGenerator,
) : SymbolProcessor {

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(ANNOTATION_QUALIFIED_NAME)

        symbols.forEach { symbol ->
            symbol as KSClassDeclaration

            val file = symbol.containingFile!!
            val newClassName = "${symbol.simpleName.asString()}Dependency"
            val pkg = file.packageName.asString()

            val output =
                PrintWriter(
                    generator.createNewFile(
                        dependencies = Dependencies(aggregating = false, file),
                        packageName = pkg,
                        fileName = newClassName,
                    )
                )

            output.appendLine("package $pkg")
            output.appendLine()
            output.appendLine("import javax.inject.Inject")
            output.appendLine()
            output.appendLine("class $newClassName @Inject constructor()")

            output.flush()
            output.close()
        }

        return emptyList()
    }

    private companion object {
        private const val ANNOTATION_NAME = "MyAnnotation"
        private const val ANNOTATION_QUALIFIED_NAME = "com.example.myapplication.utils.$ANNOTATION_NAME"
    }
}
