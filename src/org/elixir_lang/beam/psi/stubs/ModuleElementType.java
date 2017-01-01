package org.elixir_lang.beam.psi.stubs;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LighterAST;
import com.intellij.lang.LighterASTNode;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.*;
import org.elixir_lang.psi.stub.call.Stubbic;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static org.elixir_lang.psi.stub.type.Named.indexStubbic;
import static org.elixir_lang.psi.stub.type.call.Stub.serializeStubbic;

/**
 *
 * @param <S> The stub element that {@link #serialize(StubElement, StubOutputStream)} and
 *   {@link #indexStub(StubElement, IndexSink)} should accept.  These stubs should be created by
 *   {@link org.elixir_lang.beam.psi.BeamFileImpl#buildFileStub(VirtualFile, byte[])}.
 * @param <P> The PSI element that should be returned by {@link #createPsi(StubElement)} in subclasses
 */
public abstract class ModuleElementType<S extends StubElement & Stubbic, P extends PsiElement>
        extends ModuleStubElementType<S, P> {
    /**
     * @throws IllegalArgumentException stubs should never be created from {@link LighterAST} and
     *   {@link LighterASTNode}:  Stubs should be created by
     *   {@link org.elixir_lang.beam.psi.BeamFileImpl#buildFileStub(VirtualFile, byte[])}.
     */
    @Override
    public S createStub(LighterAST tree, LighterASTNode node, StubElement parentStub) {
       throw new IllegalArgumentException(
               "ModuleElementType should never create stubs from LighterAST tree as they are only create from " +
                       "BeamFileImpl#buildFileStub and ModuleElementType#deserialize"
       );
    }

    /**
     * @param id Unique ID in {@link ModuleStubElementTypes}.  Used to lookup the subclass by {@link #getExternalId()}
     *           when calling {{@link #deserialize(StubInputStream, Stub)}}.
     */
    ModuleElementType(@NotNull String id) {
        super(id);
    }

    /**
     * @throws IllegalArgumentException {@link PsiElement} should never be created from {@link ASTNode} because
     *   {@link S} is for binary {@link org.elixir_lang.beam.psi.BeamFileImpl}.  Only
     *   {{@link #createStub(PsiElement, StubElement)}} should be used to create {@link PsiElement} from {@link S}.
     */
    @Override
    public P createPsi(@NotNull ASTNode node) {
        throw new IllegalArgumentException(
                "ModuleElementType stubs should never have psi created from ASTNodes as they are only created from " +
                        "BeamFileImpl#buildFileStub and ModuleElementType#deserialize"
        );
    }

    /**
     * Serializes {@code stub} as a {@link Stubbic}.
     *
     * @param stub created by {@link org.elixir_lang.beam.psi.BeamFileImpl#buildFileStub(VirtualFile, byte[])}
     * @param dataStream stream to write {@code stub} to
     * @throws IOException if {@code dataStream} cannot be written to
     */
    @Override
    public void serialize(@NotNull S stub, @NotNull StubOutputStream dataStream) throws IOException {
        serializeStubbic(stub, dataStream);
    }

    /**
     * Indexes {@code stub} as a {@link Stubbic}.
     *
     * @param stub created by {@link org.elixir_lang.beam.psi.BeamFileImpl#buildFileStub(VirtualFile, byte[])}
     * @param sink stub index
     */
    @Override
    public void indexStub(@NotNull S stub, @NotNull IndexSink sink) {
        indexStubbic(stub, sink);
    }
}
