// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.elixir_lang.psi.ElixirTypes.*;
import org.elixir_lang.psi.*;

public class ElixirMatchedExpressionRelationalMatchedExpressionOperationImpl extends ElixirMatchedExpressionComparisonMatchedExpressionOperationImpl implements ElixirMatchedExpressionRelationalMatchedExpressionOperation {

  public ElixirMatchedExpressionRelationalMatchedExpressionOperationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ElixirVisitor) ((ElixirVisitor)visitor).visitMatchedExpressionRelationalMatchedExpressionOperation(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ElixirMatchedExpressionArrowMatchedExpressionOperation> getMatchedExpressionArrowMatchedExpressionOperationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ElixirMatchedExpressionArrowMatchedExpressionOperation.class);
  }

  @Override
  @NotNull
  public List<ElixirRelationalInfixOperator> getRelationalInfixOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ElixirRelationalInfixOperator.class);
  }

}
