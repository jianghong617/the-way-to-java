// This is a generated file. Not intended for manual editing.
package com.photowey.plugin.xcurl.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.photowey.plugin.xcurl.lang.CURLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.photowey.plugin.xcurl.lang.psi.*;

public class CURLKvImpl extends ASTWrapperPsiElement implements CURLKv {

  public CURLKvImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CURLVisitor visitor) {
    visitor.visitKv(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CURLVisitor) accept((CURLVisitor)visitor);
    else super.accept(visitor);
  }

}
