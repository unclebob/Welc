package com.om.analysis;
import java.util.List;

public class CppClass {
	private String name;

	private List<Declaration> declarations;

	public CppClass(String name, List<Declaration> declarations) {
		this.name = name;
		this.declarations = declarations;
	}

	public int getDeclarationCount() {
		return declarations.size();
	}

	public String getName() {
		return name;
	}

	public Declaration getDeclaration(int index) {
		return (Declaration) declarations.get(index);
	}

	public String getInterface(String interfaceName, int[] indices) {
		String result = "class " + interfaceName + " {\npublic:\n";
		for (int n = 0; n < indices.length; n++) {
			Declaration virtualFunction = (Declaration) declarations
					.get(indices[n]);
			result += "\t" + virtualFunction.asAbstract() + "\n";
		}
		result += "};\n";
		return result;
	}
}
