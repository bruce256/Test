// Generated from /work/github/Test/src/main/java/antlr/gen/el/El.g4 by ANTLR 4.5.3
package antlr.gen.el.antlr;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ElParser extends Parser {
	
	static {
		RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION);
	}
	
	protected static final DFA[]                  _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	public static final    int
												  T__0                = 1, T__1 = 2, T__2 = 3, ADD = 4, SUBTRACT = 5, MULTIPLY = 6, DIVIDE = 7, ID = 8,
			NUM                                                       = 9, SEMICOLON = 10, WS = 11;
	public static final int
			RULE_program = 0, RULE_stat = 1;
	public static final String[] ruleNames = {
			"program", "stat"
	};
	
	private static final String[]   _LITERAL_NAMES  = {
			null, "'('", "')'", "'='", "'+'", "'-'", "'*'", "'/'", null, null, "';'"
	};
	private static final String[]   _SYMBOLIC_NAMES = {
			null, null, null, null, "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "ID",
			"NUM", "SEMICOLON", "WS"
	};
	public static final  Vocabulary VOCABULARY      = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
	
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}
			
			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}
	
	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}
	
	@Override
	
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}
	
	@Override
	public String getGrammarFileName() {
		return "El.g4";
	}
	
	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}
	
	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}
	
	@Override
	public ATN getATN() {
		return _ATN;
	}
	
	public ElParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}
	
	public static class ProgramContext extends ParserRuleContext {
		
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class, i);
		}
		
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		
		@Override
		public int getRuleIndex() {
			return RULE_program;
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterProgram(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitProgram(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(7);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(4);
							stat(0);
							setState(5);
							match(SEMICOLON);
						}
					}
					setState(9);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ID) | (1L << NUM))) != 0));
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}
	
	public static class StatContext extends ParserRuleContext {
		
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		
		@Override
		public int getRuleIndex() {
			return RULE_stat;
		}
		
		public StatContext() {
		}
		
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	
	public static class AddContext extends StatContext {
		
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class, i);
		}
		
		public AddContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterAdd(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitAdd(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public static class DivideContext extends StatContext {
		
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class, i);
		}
		
		public DivideContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterDivide(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitDivide(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public static class NumContext extends StatContext {
		
		public TerminalNode NUM() {
			return getToken(ElParser.NUM, 0);
		}
		
		public NumContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterNum(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitNum(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public static class MultiplyContext extends StatContext {
		
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class, i);
		}
		
		public MultiplyContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterMultiply(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitMultiply(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public static class SubtractContext extends StatContext {
		
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class, i);
		}
		
		public SubtractContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterSubtract(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitSubtract(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitSubtract(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public static class IdContext extends StatContext {
		
		public TerminalNode ID() {
			return getToken(ElParser.ID, 0);
		}
		
		public IdContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterId(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitId(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public static class ParenthesisContext extends StatContext {
		
		public StatContext stat() {
			return getRuleContext(StatContext.class, 0);
		}
		
		public ParenthesisContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterParenthesis(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitParenthesis(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public static class AssignContext extends StatContext {
		
		public TerminalNode ID() {
			return getToken(ElParser.ID, 0);
		}
		
		public StatContext stat() {
			return getRuleContext(StatContext.class, 0);
		}
		
		public AssignContext(StatContext ctx) {
			copyFrom(ctx);
		}
		
		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).enterAssign(this);
		}
		
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof ElListener) ((ElListener) listener).exitAssign(this);
		}
		
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof ElVisitor) return ((ElVisitor<? extends T>) visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	
	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}
	
	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx   = _ctx;
		int               _parentState = getState();
		StatContext       _localctx    = new StatContext(_ctx, _parentState);
		StatContext       _prevctx     = _localctx;
		int               _startState  = 2;
		enterRecursionRule(_localctx, 2, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(21);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
					case 1: {
						_localctx = new ParenthesisContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						
						setState(12);
						match(T__0);
						setState(13);
						stat(0);
						setState(14);
						match(T__1);
					}
					break;
					case 2: {
						_localctx = new AssignContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(16);
						match(ID);
						setState(17);
						match(T__2);
						setState(18);
						stat(3);
					}
					break;
					case 3: {
						_localctx = new IdContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(19);
						match(ID);
					}
					break;
					case 4: {
						_localctx = new NumContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(20);
						match(NUM);
					}
					break;
				}
				_ctx.stop = _input.LT(-1);
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null) triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(35);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
								case 1: {
									_localctx = new MultiplyContext(new StatContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_stat);
									setState(23);
									if (!(precpred(_ctx, 8)))
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									setState(24);
									match(MULTIPLY);
									setState(25);
									stat(9);
								}
								break;
								case 2: {
									_localctx = new DivideContext(new StatContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_stat);
									setState(26);
									if (!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(27);
									match(DIVIDE);
									setState(28);
									stat(8);
								}
								break;
								case 3: {
									_localctx = new AddContext(new StatContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_stat);
									setState(29);
									if (!(precpred(_ctx, 6)))
										throw new FailedPredicateException(this, "precpred(_ctx, 6)");
									setState(30);
									match(ADD);
									setState(31);
									stat(7);
								}
								break;
								case 4: {
									_localctx = new SubtractContext(new StatContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_stat);
									setState(32);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(33);
									match(SUBTRACT);
									setState(34);
									stat(6);
								}
								break;
							}
						}
					}
					setState(39);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}
	
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 1:
				return stat_sempred((StatContext) _localctx, predIndex);
		}
		return true;
	}
	
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return precpred(_ctx, 8);
			case 1:
				return precpred(_ctx, 7);
			case 2:
				return precpred(_ctx, 6);
			case 3:
				return precpred(_ctx, 5);
		}
		return true;
	}
	
	public static final String _serializedATN =
			"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r+\4\2\t\2\4\3\t" +
					"\3\3\2\3\2\3\2\6\2\n\n\2\r\2\16\2\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
					"\3\3\3\5\3\30\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3" +
					"&\n\3\f\3\16\3)\13\3\3\3\2\3\4\4\2\4\2\2\60\2\t\3\2\2\2\4\27\3\2\2\2\6" +
					"\7\5\4\3\2\7\b\7\f\2\2\b\n\3\2\2\2\t\6\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2" +
					"\2\13\f\3\2\2\2\f\3\3\2\2\2\r\16\b\3\1\2\16\17\7\3\2\2\17\20\5\4\3\2\20" +
					"\21\7\4\2\2\21\30\3\2\2\2\22\23\7\n\2\2\23\24\7\5\2\2\24\30\5\4\3\5\25" +
					"\30\7\n\2\2\26\30\7\13\2\2\27\r\3\2\2\2\27\22\3\2\2\2\27\25\3\2\2\2\27" +
					"\26\3\2\2\2\30\'\3\2\2\2\31\32\f\n\2\2\32\33\7\b\2\2\33&\5\4\3\13\34\35" +
					"\f\t\2\2\35\36\7\t\2\2\36&\5\4\3\n\37 \f\b\2\2 !\7\6\2\2!&\5\4\3\t\"#" +
					"\f\7\2\2#$\7\7\2\2$&\5\4\3\b%\31\3\2\2\2%\34\3\2\2\2%\37\3\2\2\2%\"\3" +
					"\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2)\'\3\2\2\2\6\13\27%" +
					"\'";
	public static final ATN    _ATN           =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}